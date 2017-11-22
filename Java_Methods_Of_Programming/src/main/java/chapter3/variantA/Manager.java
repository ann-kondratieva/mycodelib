package chapter3.variantA;

import java.util.Scanner;

enum Faculties {KSIS, FKP, IEF}

public class Manager {

    public static void main(String[] args) {
        Student[] students = new Student[4];
        students[0] = new Student("Ivanov I.I.", "21.12.1998","Minsk, Pushkina 23", "+375291234560", Faculties.IEF.name(),1,"712345");
        students[1] = new Student("Sidorov I.I.", "31.06.1998","Minsk, Pushkina 24", "+375293214560", Faculties.FKP.name(),1,"712345");
        students[2] = new Student("Stepanova I.I.", "12.06.1998","Minsk, Pushkina 25", "+375291254360", Faculties.KSIS.name(),1,"712346");
        students[3] = new Student("Kolchanov I.I.", "06.11.1998","Minsk, Pushkina 26", "+375291234065", Faculties.IEF.name(),1,"712345");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input a faculty: ");
        String faculty = scanner.nextLine();
        findByFaculty(students,faculty);

        listOfStudentsByFacultyAndCourse(students);

        System.out.println("Input a year: ");
        int year = scanner.nextInt();
        studentsAfterYear(students, year);

        scanner.nextLine();

        System.out.println("Input a group: ");
        String group = scanner.nextLine();
        studentsFromGroup(students,group);






    }

    public static void findByFaculty(Student[] students, String faculty){
        for(int i=0; i<students.length; i++){
            if(students[i].getFaculty().equals(faculty)){
                System.out.println(students[i]);
            }
        }
    }

    public static void listOfStudentsByFacultyAndCourse(Student[] students){
        Faculties[] faculties = Faculties.values();
        for(int i=0; i<faculties.length; i++){
            System.out.println(faculties[i].name()+": ");
            for(int j=0; j<5; j++){
                System.out.println("Course "+j+": ");
                for(int k=0; k<students.length; k++){
                    if(students[k].getFaculty().equals(faculties[i].name()) &&
                            students[k].getCourse()==j){
                        System.out.println(students[k]);
                    }
                }
            }
        }
    }

    public static void studentsAfterYear(Student[] students,int year){
        for(int i=0; i<students.length; i++){
            String[] bday = students[i].getBday().split("\\.");
            if(Integer.parseInt(bday[2])>year){
                System.out.println(students[i]);
            }
        }
    }

    public static void studentsFromGroup(Student[] students,String group){
        for(int i=0; i<students.length; i++){
            if(students[i].getGroup().equals(group)){
                System.out.println(students[i]);
            }
        }
    }





}