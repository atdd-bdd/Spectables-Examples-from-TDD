package spectable.common;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import production.*;

public class TransactionCasesTyped {
    public ListOfDollarTyped transactions;
    public java.math.BigDecimal result;
    public String notes;

    public TransactionCasesTyped(ListOfDollarTyped transactions, java.math.BigDecimal result, String notes) {
        this.transactions = transactions;
        this.result = result;
        this.notes = notes;
    }

    public TransactionCasesTyped(TransactionCasesString s) {
        this.transactions = new ListOfDollarTyped(s.transactions);
        this.result = new java.math.BigDecimal(s.result);
        this.notes = s.notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionCasesTyped)) return false;
        TransactionCasesTyped that = (TransactionCasesTyped) o;
        return Objects.equals(transactions, that.transactions)
            && Objects.equals(result, that.result)
            && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactions, result, notes);
    }

    public TransactionCasesString toTransactionCasesString() {
        return new TransactionCasesString(String.valueOf(transactions), String.valueOf(result), String.valueOf(notes));
    }

    public static List<TransactionCasesTyped> fromStringList(List<TransactionCasesString> list) {
        List<TransactionCasesTyped> result = new ArrayList<>();
        for (TransactionCasesString s : list) result.add(new TransactionCasesTyped(s));
        return result;
    }

    public static List<TransactionCasesString> toStringList(List<TransactionCasesTyped> list) {
        List<TransactionCasesString> result = new ArrayList<>();
        for (TransactionCasesTyped t : list) result.add(t.toTransactionCasesString());
        return result;
    }

    /** Internal plumbing for {@link Json}; use toJSON() for JSON text. */
    public Map<String, Object> toJsonValue() {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        m.put("transactions", transactions == null ? null : transactions.toString());
        m.put("result", result);
        m.put("notes", notes);
        return m;
    }

    public String toJSON() { return Json.write(toJsonValue()); }

    /** Internal plumbing for {@link Json}; use fromJSON(String) for JSON text. */
    public static TransactionCasesTyped fromJsonValue(Map<String, Object> m) {
        if (m == null) return null;
        return new TransactionCasesTyped(
            new ListOfDollarTyped(new ListOfDollarString(Json.asString(Json.require(m, "transactions"), "transactions"))),
            Json.asDecimal(Json.require(m, "result"), "result"),
            Json.asString(Json.require(m, "notes"), "notes"));
    }

    public static TransactionCasesTyped fromJSON(String json) {
        return fromJsonValue(Json.parseObject(json));
    }

    public static String toJSONList(List<TransactionCasesTyped> list) {
        List<Object> arr = new ArrayList<Object>();
        if (list != null)
            for (TransactionCasesTyped item : list) arr.add(item == null ? null : item.toJsonValue());
        return Json.write(arr);
    }

    public static List<TransactionCasesTyped> fromJSONList(String json) {
        List<TransactionCasesTyped> result = new ArrayList<TransactionCasesTyped>();
        for (Object e : Json.parseArray(json))
            result.add(fromJsonValue(Json.asObject(e, "TransactionCasesTyped")));
        return result;
    }
}
