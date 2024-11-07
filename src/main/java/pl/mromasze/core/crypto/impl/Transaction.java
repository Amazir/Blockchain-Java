package pl.mromasze.core.crypto.impl;

import org.apache.commons.codec.digest.DigestUtils;
import pl.mromasze.core.crypto.ITransaction;

public class Transaction implements ITransaction {
    private final double amount;
    private final String lastTransaction;
    private final int nonce;

    public Transaction(double amount, String lastTransaction, int nonce) {
        this.amount = amount;
        this.lastTransaction = lastTransaction;
        this.nonce = nonce;
    }

    @Override
    public String toString() {
        return String.format("{\"amount\": %.2f, \"lastTransaction\": \"%s\", \"nonce\": %d}",
                amount, lastTransaction, nonce);
    }

    @Override
    public String generateHash() {return DigestUtils.sha256Hex(this.toString());}
}
