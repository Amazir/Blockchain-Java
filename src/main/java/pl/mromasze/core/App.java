package pl.mromasze.core;

import pl.mromasze.core.crypto.ITransaction;
import pl.mromasze.core.crypto.impl.TransactionChain;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        TransactionChain chain = TransactionChain.getInstance();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            double amount = 10 + (1000 - 10) * random.nextDouble();
            chain.addTransaction(amount);
        }

        System.out.println("Transaction list:");
        List<ITransaction> transactions = chain.getTransactions();

        for (int i = 0; i < transactions.size(); i++)
            System.out.println("Transaction " + (i + 1) + ": " + transactions.get(i));
    }
}
