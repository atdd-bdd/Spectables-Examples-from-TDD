package spectable.common;

import java.util.Objects;
import production.*;

public class TransactionCasesString {
    private static final String DNCString = "?DNC?";

    public ListOfDollarString transactions;
    public String result;
    public String notes;

    public TransactionCasesString(String transactions, String result, String notes) {
        this.transactions = new ListOfDollarString(transactions);
        this.result = result;
        this.notes = notes;
    }

    /** Builds from the text form, e.g. Money as "25 USD". */
    public static TransactionCasesString fromText(String text) {
        java.util.List<String> parts = Tokens.require(text, 3, "TransactionCases");
        return new TransactionCasesString(parts.get(0), parts.get(1), parts.get(2));
    }

    public TransactionCasesString(String text) {
        TransactionCasesString parsed = fromText(text);
        this.transactions = parsed.transactions;
        this.result = parsed.result;
        this.notes = parsed.notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionCasesString)) return false;
        TransactionCasesString that = (TransactionCasesString) o;
        return (DNCString.equals(transactions.value) || DNCString.equals(that.transactions.value) || Objects.equals(transactions.value, that.transactions.value))
            && (DNCString.equals(result) || DNCString.equals(that.result) || Objects.equals(result, that.result))
            && (DNCString.equals(notes) || DNCString.equals(that.notes) || Objects.equals(notes, that.notes));
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactions, result, notes);
    }

    @Override
    public String toString() {
        return Tokens.token(transactions.value) + " " + Tokens.token(result) + " " + Tokens.token(notes);
    }
}
