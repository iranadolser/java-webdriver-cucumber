package pages;

public class UserInfo {

    protected String name;
    protected String age;
    protected boolean student;
    protected boolean retired;

        public UserInfo(String name, String age, Boolean student, Boolean retired) {
            this.name = name;
            this.age = age;
            this.student = student;
            this.retired = retired;
        }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isRetired() {
        return retired;
    }
    public void setRetired(boolean retired) {
        this.retired = retired;
    }
    public boolean isStudent() {
        return student;
    }
    public void setStudent(boolean student) {
        this.student = student;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }


}
