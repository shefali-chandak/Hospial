package com.Doctor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainApplication {
    public static void main(String[] args) throws ParseException, IOException {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //shift1
        /*SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Shift shift = new Shift(1,"Yes",format.parse("03/24/2011"));*/

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        do{
            System.out.println("Enter your choice: \n1.Insert\n2.Fetch\n3.Exit");
            int choice = Integer.parseInt(bufferedReader.readLine());
            switch (choice){
                case 1:
                    System.out.println("Enter patient id,name,mobile no.,emergency mobile no.,blood grp,allergy:");

                    Patient patient = new Patient();
                    patient.setPatient_id(Integer.parseInt(bufferedReader.readLine()));
                    patient.setPatient_name(bufferedReader.readLine());
                    patient.setPatient_mobile_no(Long.parseLong(bufferedReader.readLine()));
                    patient.setPatient_emergency_no(Long.parseLong(bufferedReader.readLine()));
                    patient.setPatient_blood_grp(bufferedReader.readLine());
                    patient.setAllergies(bufferedReader.readLine());

                    System.out.println("Enter no. of doctors for patient::");
                    int doc_count = Integer.parseInt(bufferedReader.readLine());

                    Set<Doctor> doctorSet = new HashSet<>();
                    for (int i = 0; i < doc_count; i++) {
                        System.out.println("Enter doctor lic_id,name,mobile no,exp");
                        Doctor doctor = new Doctor();
                        doctor.setLicense_id(Integer.parseInt(bufferedReader.readLine()));
                        doctor.setDoc_name(bufferedReader.readLine());
                        doctor.setDoc_mobile_no(Long.parseLong(bufferedReader.readLine()));
                        doctor.setDoc_experience(Integer.parseInt(bufferedReader.readLine()));

                        System.out.println("Enter the shift details of doctor::");
                        System.out.println("Enter Doctor shift (morning/evening/night) ");
                        String str = bufferedReader.readLine();
                        if (str.equalsIgnoreCase("morning")) {
                            doctor.setShift(Doctor.MORNING);
                        } else if (str.equalsIgnoreCase("evening")) {
                            doctor.setShift(Doctor.EVENING);
                        } else {
                            doctor.setShift(Doctor.NIGHT);
                        }

                        System.out.println("Which department does doctor belong to ? \n1.Gynac \n2.Surgeon");
                        int dept_id = Integer.parseInt(bufferedReader.readLine());
                        Department department = session.load(Department.class, dept_id);
                        doctor.setDepartment(department);

                        Set<Staff> staffSet = new HashSet<>();
                        System.out.println("Enter no. of staff for doctor::");
                        int staff_count = Integer.parseInt(bufferedReader.readLine());
                        for (int j = 0; j < staff_count; j++) {
                            System.out.println("Enter staff id,name,mobile no,exp");
                            Staff staff = new Staff();
                            staff.setStaff_id(Integer.parseInt(bufferedReader.readLine()));
                            staff.setStaff_name(bufferedReader.readLine());
                            staff.setStaff_mobile_no(Long.parseLong(bufferedReader.readLine()));
                            staff.setStaff_experience(Integer.parseInt(bufferedReader.readLine()));


                            System.out.println("Which department does staff belong to ? \n1.Gynac \n2.Surgeon");
                            int depart_id = Integer.parseInt(bufferedReader.readLine());
                            Department department1 = session.load(Department.class, depart_id);

                            staff.setDepartment(department1);
                            staffSet.add(staff);
                        }
                        doctor.setStaff(staffSet);
                        doctorSet.add(doctor);
                    }
                    patient.setDoctor(doctorSet);
                    session.save(patient);
                    transaction.commit();
                    break;

                case 2:
                    System.out.println("Enter data to be fetched \n1.Patient\n2.Doctor\n3.Staff\n4.Department\n5.Exit");
                    int option = Integer.parseInt(bufferedReader.readLine());
                    switch (option)
                    {
                        case 1:
                            session = sessionFactory.openSession();
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
                            System.out.println("*****Patients*********");
                            for (Department l : list4) {
                                System.out.println(l);
                            }
                            break;
                        case 5:
                            System.exit(0);
                            break;
                    }
                    break;

                case 3:
                    System.out.println("THANKYOU!!");
                    System.exit(0);
                    break;
            }
        }while (true);
    }
}
