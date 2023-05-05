package stage3;

public class Organization extends Contacts{
    String organizationName;
    String address;

    public Organization() {
    }
    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Organization name: " + organizationName + "\n" +
                "Address: " + address + "\n" +
                "Number: " + number + "\n" +
                "Time created: " + creation +"\n"+
                "Time last edit: " + edition ;
    }

    @Override
    public String getFullName() {
        return organizationName;
    }
}