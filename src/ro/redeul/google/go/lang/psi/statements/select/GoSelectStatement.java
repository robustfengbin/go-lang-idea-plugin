package ro.redeul.google.go.lang.psi.statements.select;

import ro.redeul.google.go.lang.psi.statements.GoStatement;

public interface GoSelectStatement extends GoStatement {

    GoSelectCommClause[] getCommClauses();

}
