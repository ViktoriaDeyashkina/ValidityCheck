import javax.management.InvalidApplicationException;
import java.io.IOException;

public class Controller {
    private View view = new View(Controller.this);

    public static void main(String[] args) {
        Controller controller = new Controller();

    }

    public void notifyChecking(boolean checking) {
        view.notifyChecking(checking);
    }
    public void checkTaxNumber() {
          while (true) {
              try {
                  TaxNumber taxNumber = new TaxNumber(view.getTaxNumber());
                  boolean checking = taxNumber.checkValidity();
                  notifyChecking(checking);  }       catch (Exception e) {
                  break;
              }
          }
    }

    public void checkInsuaranceNumber() {
         while (true) {
             try {
                 InsuranceNumber insuranceNumber = new InsuranceNumber(view.getInsuaranceNumber());
                 notifyChecking(insuranceNumber.checkValidity());
             } catch (Exception e) {
                 break;
             }
         }
    }

    public void checkCountNumber() {
        while (true) {
            try {
                CountNumber countNumber = new CountNumber(view.getBICNumber(), view.getCountNumber());
                notifyChecking(countNumber.checkValidity());
            } catch (Exception e) {
                break;
            }
        }
    }
}
