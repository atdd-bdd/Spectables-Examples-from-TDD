package spectable.tests;

import java.util.List;
import java.util.ArrayList;
import spectable.common.*;
import spectable.Bank_Account_glue;
import production.*;
import org.junit.jupiter.api.Test;

public class Bank_Account_Test {

    // -------------------------
    // Calculation Tests
    // -------------------------
    @Test
    public void Calculation_Calculate_Account_Balance() {
        Bank_Account_glue glue = new Bank_Account_glue();
        List<TransactionCasesString> objectList1 = new ArrayList<>();
        objectList1.add(new TransactionCasesString("", "0.00", "No transactions produce a zero balance."));
        objectList1.add(new TransactionCasesString("100", "100.00", "Single deposit."));
        objectList1.add(new TransactionCasesString("-25", "-25.00", "Single withdrawal."));
        objectList1.add(new TransactionCasesString("100,-25", "75.00", "Deposit followed by withdrawal."));
        objectList1.add(new TransactionCasesString("100,50", "150.00", "Multiple deposits are summed."));
        objectList1.add(new TransactionCasesString("-50,-25", "-75.00", "Multiple withdrawals are summed."));
        objectList1.add(new TransactionCasesString("100,-25,50", "125.00", "Running balance after mixed activity."));
        objectList1.add(new TransactionCasesString("500,-200,-100", "200.00", "Deposits and withdrawals net together."));
        objectList1.add(new TransactionCasesString("1000,-250,75", "825.00", "Balance reflects all transactions."));
        objectList1.add(new TransactionCasesString("50,-50", "0.00", "Equal deposit and withdrawal cancel."));
        objectList1.add(new TransactionCasesString("1,2,3,4", "10.00", "All transactions contribute equally."));
        glue.Examples_Calculation_Calculate_Account_Balance(objectList1);
    }

    // -------------------------
    // DataType Tests
    // -------------------------
    @Test
    public void DataType_Dollar() {
        Bank_Account_glue glue = new Bank_Account_glue();
        List<ValidValuesString> objectList2 = new ArrayList<>();
        objectList2.add(new ValidValuesString("$0.00", "True", ""));
        objectList2.add(new ValidValuesString("$1.00", "True", ""));
        objectList2.add(new ValidValuesString("$100.50", "True", ""));
        objectList2.add(new ValidValuesString("$-25.75", "True", "Negative amounts are allowed."));
        objectList2.add(new ValidValuesString("100.00", "False", "Dollar values must begin with $."));
        objectList2.add(new ValidValuesString("$12.345", "False", "More than two decimal places."));
        objectList2.add(new ValidValuesString("$ABC", "False", "Not a numeric amount."));
        objectList2.add(new ValidValuesString("$", "False", "Amount is missing."));
        glue.Examples_DataType_Dollar(objectList2);
    }

    @Test
    public void DataType_ListOfDollar() {
        Bank_Account_glue glue = new Bank_Account_glue();
        List<ValidValuesString> objectList3 = new ArrayList<>();
        objectList3.add(new ValidValuesString("", "True", "Empty list."));
        objectList3.add(new ValidValuesString("$100.00", "True", "Single value."));
        objectList3.add(new ValidValuesString("$100.00,$50.00", "True", "Multiple values."));
        objectList3.add(new ValidValuesString("$-25.00", "True", "Negative values are allowed."));
        objectList3.add(new ValidValuesString("$100.00,$-25.00,$50.00", "True", "Mixed"));
        glue.Examples_DataType_ListOfDollar(objectList3);
    }

}
