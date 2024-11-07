package pl.mromasze.core.crypto;

public interface ITransactionChain {
    void addTransaction(double amount);
    java.util.List<ITransaction> getTransactions();
}