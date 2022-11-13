
import java.util.ArrayList;
import java.util.List;


class InsuranceNumber {
    private String incomingNumber;

    public InsuranceNumber(String incomingNumber) {
        this.incomingNumber = incomingNumber;
    }

    public boolean checkValidity() {
            StringBuilder builder = new StringBuilder(incomingNumber);
            String controlNumber1 = builder.substring(12, incomingNumber.length());
            int controlNumber = Integer.parseInt(controlNumber1);
            ArrayList<String> insuranceNumber1 = new ArrayList<String>(List.of(incomingNumber.split("")));
            insuranceNumber1.remove(3);
            insuranceNumber1.remove(6);
            insuranceNumber1.remove(9);
            ArrayList<Integer> insuranceNumber = new ArrayList<>(insuranceNumber1.size());

            for (int i = 0; i < insuranceNumber1.size(); i++) {
                insuranceNumber.add(i, Integer.parseInt(insuranceNumber1.get(i)));
            }
            int sum = insuranceNumber.get(0) * 9 + insuranceNumber.get(1) * 8 + insuranceNumber.get(2) * 7 + insuranceNumber.get(3) * 6 + insuranceNumber.get(4) * 5 + insuranceNumber.get(5) * 4 + insuranceNumber.get(6) * 3 + insuranceNumber.get(7) * 2 + insuranceNumber.get(8) * 1;
            if (sum < 100) {
                if (sum == controlNumber) {
                    return true;
                } else return false;
            } else if (sum == 100 || sum == 101) {
                if (controlNumber == 00) {
                    return true;
                } else return false;
            } else if (sum > 101) {
                int sum2 = sum % 101;
                if (sum2 < 100) {
                    if (sum2 == controlNumber) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (sum2 == 100) {
                    if (controlNumber == 00) {
                        return true;
                    } else return false;
                }
            }
        return false;
    }
}
