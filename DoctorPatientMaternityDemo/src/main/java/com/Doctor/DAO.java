package com.Doctor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DAO {
    static Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    static SessionFactory sessionFactory = configuration.buildSessionFactory();
    static Session session = sessionFactory.openSession();
    static Transaction transaction = session.beginTransaction();

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void insertRecord() throws IOException, ParseException {
        System.out.println("Enter patient id,name,mobile no.,emergency mobile no.,blood grp,allergy:");

        Patient patient = new Patient();
        patient.setPatient_id(Integer.parseInt(bufferedReader.readLine()));
        patient.setPatient_name(bufferedReader.readLine());
        patient.setPatient_mobile_no(Long.parseLong(bufferedReader.readLine()));
        patient.setPatient_emergency_no(Long.parseLong(bufferedReader.readLine()));
        patient.setPatient_blood_grp(bufferedReader.readLine());
        patient.setAllergies(bufferedReader.readLine());

        List<Monthly_Details> monthly_detailsSet = new ArrayList<>();
        int temp = 1;
        while (temp != 111) {
            Monthly_Details monthly_details = new Monthly_Details();
            System.out.println("Enter record_id,pregnancy start date and end date, sonography details,BP,Sugar");
            monthly_details.setRecord_id(Integer.parseInt(bufferedReader.readLine()));

            System.out.println("Enter date in format dd/MM/yyyy only");
            String date = bufferedReader.readLine();
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            monthly_details.setPreg_start_date(date1);

            System.out.println("Enter date in format dd/MM/yyyy only");
            String date2 = bufferedReader.readLine();
            Date date3 = new SimpleDateFormat("dd/MM/yyyy").parse(date2);
            monthly_details.setPreg_due_date(date3);

            monthly_details.setSonography_details(bufferedReader.readLine());
            monthly_details.setBP(Float.parseFloat(bufferedReader.readLine()));
            monthly_details.setSugar(Float.parseFloat(bufferedReader.readLine()));
            monthly_detailsSet.add(monthly_details);

            System.out.println("If don't want to add more details write 111: ");
            temp = Integer.parseInt(bufferedReader.readLine());
        }
        patient.setMonthly_details(monthly_detailsSet);

        System.out.println("Enter no. of doctors for patient::");
        int doc_count = Integer.parseInt(bufferedReader.readLine());

        Set<Doctor> doctorSet = new HashSet<>();
        for (int i = 0; i < doc_count; i++) {
            System.out.println("Enter doctor lic_id,name,mobile no,exp,gender");
            Doctor doctor = new Doctor();
            doctor.setLicense_id(Integer.parseInt(bufferedReader.readLine()));
            doctor.setDoc_name(bufferedReader.readLine());
            doctor.setDoc_mobile_no(Long.parseLong(bufferedReader.readLine()));
            doctor.setDoc_experience(Integer.parseInt(bufferedReader.readLine()));
            doctor.setGender(bufferedReader.readLine());

            List<Qualification> qualificationList = new ArrayList<>();
            System.out.println("Enter qualification to be added: ");
            int qual_list = Integer.parseInt( bufferedReader.readLine());
            for (int k=0;k<qual_list;k++){
                System.out.println("Enter qualification details: id,degree,passing year,percentage: ");
                Qualification qualification = new Qualification();
                qualification.setQualifcation_id(Integer.parseInt(bufferedReader.readLine()));
                qualification.setDegree(bufferedReader.readLine());
                qualification.setPassing_year(Integer.parseInt(bufferedReader.readLine()));
                qualification.setPercentage(Float.parseFloat(bufferedReader.readLine()));
                qualificationList.add(qualification);
            }
            doctor.setQualificationList(qualificationList);

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
                System.out.println("Enter staff id,name,mobile no,exp,gender");
                Staff staff = new Staff();
                staff.setStaff_id(Integer.parseInt(bufferedReader.readLine()));
                staff.setStaff_name(bufferedReader.readLine());
                staff.setStaff_mobile_no(Long.parseLong(bufferedReader.readLine()));
                staff.setStaff_experience(Integer.parseInt(bufferedReader.readLine()));
                staff.setGender(bufferedReader.readLine());

                List<Qualification> qualificationList1 = new ArrayList<>();
                System.out.println("Enter qualification to be added: ");
                int qual_list1 = Integer.parseInt( bufferedReader.readLine());
                for (int k=0;k<qual_list1;k++){
                    System.out.println("Enter qualification details: id,degree,passing year,percentage: ");
                    Qualification qualification = new Qualification();
                    qualification.setQualifcation_id(Integer.parseInt(bufferedReader.readLine()));
                    qualification.setDegree(bufferedReader.readLine());
                    qualification.setPassing_year(Integer.parseInt(bufferedReader.readLine()));
                    qualification.setPercentage(Float.parseFloat(bufferedReader.readLine()));
                    qualificationList1.add(qualification);
                }
                staff.setQualificationList(qualificationList1);

                System.out.println("Enter the shift details of staff::");
                System.out.println("Enter Staff shift (morning/evening/night) ");
                String str1 = bufferedReader.readLine();
                if (str1.equalsIgnoreCase("morning")) {
                    doctor.setShift(Staff.MORNING);
                } else if (str1.equalsIgnoreCase("evening")) {
                    doctor.setShift(Staff.EVENING);
                } else {
                    doctor.setShift(Staff.NIGHT);
                }

                System.out.println("Which department does staff belong to ? \n1.Gynac \n2.Surgeon");
                int depart_id = Integer.parseInt(bufferedReader.readLine());
                Department department1 = session.load(Department.class, depart_id);

                staff.setDepartment(department1);
                staffSet.add(staff);
            }
            doctor.setStaff(staffSet);
            doctorSet.add(doctor);
        }

        List<Bill> billList = new ArrayList<>();
        System.out.println("Enter Bill Details: ");
        System.out.println("Enter no. of bills to be added");
        int bill_count = Integer.parseInt(bufferedReader.readLine());
        for(int i =0; i<bill_count;i++)
        {
            Bill bill = new Bill();
            System.out.println("Enter bill no.,doc and room charges, days room occupied, room no");
            bill.setBillNo(Integer.parseInt(bufferedReader.readLine()));
            bill.setDoc_charges(Float.parseFloat(bufferedReader.readLine()));
            bill.setDays_room_occupied(Integer.parseInt(bufferedReader.readLine()));
            bill.setRoom_charges(Float.parseFloat(bufferedReader.readLine()));
            bill.setRoomNo(bufferedReader.readLine());

            System.out.println("Enter the room type::");
            System.out.println("Enter room type (special/semi/general) ");
            String str1 = bufferedReader.readLine();
            if (str1.equalsIgnoreCase("special")) {
                bill.setRoomType(bill.SpecialRoom);
            } else if (str1.equalsIgnoreCase("semi")) {
                bill.setRoomType(bill.SemiRoom);
            } else {
                bill.setRoomType(bill.GeneralWard);
            }

            billList.add(bill);
        }
        patient.setBills(billList);
        patient.setDoctor(doctorSet);
        session.save(patient);
        transaction.commit();
    }
}
