public class StatementFormatter {

  public static String buildStatement(Account account) {

        StringBuilder sb = new StringBuilder();

        sb.append("------ MINI BANK STATEMENT ------\n");

        sb.append("Account Number: ")
          .append(account.getAccountNumber())
          .append("\n");

        sb.append("Account Holder: ")
          .append(account.getHolderName())
          .append("\n");

        sb.append("Balance: Rs. ")
          .append(account.getBalance())
          .append("\n");

        sb.append("---------------------------------\n");

        return sb.toString();
    }
}