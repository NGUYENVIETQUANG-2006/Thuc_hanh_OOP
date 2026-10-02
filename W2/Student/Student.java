public class Student {
    private String id;
    private String name;
    private String email;
    private double gpa;

    public Student() {
        this.id = "";
        this.name = "";
        this.email = "";
        this.gpa = 0.0;
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.email = "";
        this.gpa = 0.0;
    }

    public Student(String id, String name, String email, double gpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        setGpa(gpa);
    }

    public Student(Student other) {
        this.id = other.id;
        this.name = other.name;
        this.email = other.email;
        this.gpa = other.gpa;
    }

    public String getId() { 
        return id; 
    }
    public String getName() { 
        return name; 
    }
    public String getEmail() { 
        return email; 
    }
    public double getGpa() { 
        return gpa; 
    }

    public void setId(String id) { 
        this.id = id; 
    }
    public void setName(String name) { 
        this.name = name; 
    }
    public void setEmail(String email) { 
        this.email = email; 
    }

    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.err.println(this.name + ": Error: GPA must be between 0.0 and 4.0. Keeping the old value: " + this.gpa);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setId("SV001");
        s1.setName("Nguyen Van A");
        s1.setEmail("a@example.com");
        s1.setGpa(3.5);

        Student s2 = new Student("SV002", "Tran Thi B");
        s2.setEmail("b@example.com");
        s2.setGpa(3.8);

        Student s3 = new Student("SV003", "Le Van C", "c@example.com", 2.9);

        s3.setGpa(-1.0);

        System.out.println(s1.getEmail() + " - " + s1.getGpa() + " - " + s1.getName() + " - " + s1.getId());
        System.out.println(s2.getEmail() + " - " + s2.getGpa() + " - " + s2.getName() + " - " + s2.getId());
        System.out.println(s3.getEmail() + " - " + s3.getGpa() + " - " + s3.getName() + " - " + s3.getId());
    }
}