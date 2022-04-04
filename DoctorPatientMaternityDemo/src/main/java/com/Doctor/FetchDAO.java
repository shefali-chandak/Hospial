package com.Doctor;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

import static com.Doctor.DAO.bufferedReader;
import static com.Doctor.DAO.sessionFactory;

public class FetchDAO
{
    public static void fetchRecords() throws IOException {
        System.out.println("Enter data to be fetched \n1.Patient\n2.Doctor\n3.Staff\n4.Department\n5.Bill\n6.Monthly Details\n7.Qualification\n8.Exit");
        int option = Integer.parseInt(bufferedReader.readLine());
        switch (option) {
            case 1:
                Session session = sessionFactory.openSession();
                Query query = session.createQuery("from Patient");
                List<Patient> list1 = query.getResultList();
                System.out.println("*****Patients*********");
                for (Patient l : list1) {
                    System.out.println(l);
                }
                break;
            case 2:
                session = sessionFactory.openSession();
                query = session.createQuery("from Doctor");
                List<Doctor> list2 = query.getResultList();
                System.out.println("******* Doctors *********");
                for (Doctor l : list2) {
                    System.out.println(l);
                }
                break;
            case 3:
                session = sessionFactory.openSession();
                query = session.createQuery("from Staff");
                List<Staff> list3 = query.getResultList();
                System.out.println("******* Staff *********");
                for (Staff l : list3) {
                    System.out.println(l);
                }
                break;
            case 4:
                session = sessionFactory.openSession();
                query = session.createQuery("from Department");
                List<Department> list4 = query.getResultList();
                System.out.println("*****Department*********");
                for (Department l : list4) {
                    System.out.println(l);
                }
                break;
            case 5:
                session = sessionFactory.openSession();
                query = session.createQuery("from Bill");
                List<Bill> list5 = query.getResultList();
                System.out.println("*****Bill*********");
                for (Bill l : list5) {
                    System.out.println(l);
                }
                break;
            case 6:
                session = sessionFactory.openSession();
                query = session.createQuery("from Monthly_Details");
                List<Monthly_Details> list6 = query.getResultList();
                System.out.println("*****Monthly_Details*********");
                for (Monthly_Details l : list6) {
                    System.out.println(l);
                }
                break;
            case 7:
                session = sessionFactory.openSession();
                query = session.createQuery("from Qualification");
                List<Qualification> list7 = query.getResultList();
                System.out.println("*****Qualification*********");
                for (Qualification l : list7) {
                    System.out.println(l);
                }
                break;
            case 8:
                System.exit(0);
                break;
        }
    }
}
