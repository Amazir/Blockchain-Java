package pl.mromasze.core.crypto.impl;

import org.apache.commons.codec.digest.DigestUtils;
import pl.mromasze.core.crypto.ITransaction;
import pl.mromasze.core.crypto.ITransactionChain;

import java.util.ArrayList;
import java.util.List;

public class TransactionChain implements ITransactionChain {
    private static TransactionChain instance = new TransactionChain();
    private final List<ITransaction> transactions;

    private TransactionChain() {
        transactions = new ArrayList<>();
    }

    public static TransactionChain getInstance() {return instance;}

    @Override
    public void addTransaction(double amount) {
        String lastTransactionHash = transactions.isEmpty()
                ? DigestUtils.sha256Hex("initial hash")
                : transactions.get(transactions.size() - 1).generateHash();

        int nonce = 0;
        String hash;

        do {
            Transaction transaction = new Transaction(amount, lastTransactionHash, nonce);
            hash = transaction.generateHash();
            nonce++;
        } while (!hash.endsWith("00000"));

        transactions.add(new Transaction(amount, lastTransactionHash, nonce - 1));
    }

    @Override
    public List<ITransaction> getTransactions() {
        return transactions;
    }
}
