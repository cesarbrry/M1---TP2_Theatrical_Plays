package theatricalplays;
import org.junit.jupiter.api.Test;

import theatricalplays.Play.TypePiece;

import java.util.List;


import static org.approvaltests.Approvals.verify;

public class StatementPrinterTests {

    @Test
    void exampleStatement() {
    

        Invoice invoice = new Invoice(new Customer("Bigco",1234,145), List.of(
                new Performance(new Play("Hamlet", TypePiece.TRAGEDY), 55),
                new Performance(new Play("As You Like It", TypePiece.COMEDY), 35),
                new Performance(new Play("Othello", TypePiece.TRAGEDY), 40)));

        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.print(invoice);

        verify(result);
    }

    @Test
    void exampleStatementHtmlCreditSup() {
    

        Invoice invoice = new Invoice(new Customer("Bigco",1234,155), List.of(
                new Performance(new Play("Hamlet", TypePiece.TRAGEDY), 55),
                new Performance(new Play("As You Like It", TypePiece.COMEDY), 35),
                new Performance(new Play("Othello", TypePiece.TRAGEDY), 40)));

        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.toHtml(invoice);

        verify(result);
    }

    @Test
    void exampleStatementHtmlCreditInf() {
    

        Invoice invoice = new Invoice(new Customer("Bigco",1234,145), List.of(
                new Performance(new Play("Hamlet", TypePiece.TRAGEDY), 55),
                new Performance(new Play("As You Like It", TypePiece.COMEDY), 35),
                new Performance(new Play("Othello", TypePiece.TRAGEDY), 40)));

        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.toHtml(invoice);

        verify(result);
    }

}
