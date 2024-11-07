package pl.mromasze.core.crypto;

public interface ITransaction {
    String toString();
    String generateHash();
}