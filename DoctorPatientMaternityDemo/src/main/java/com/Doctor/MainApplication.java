package com.Doctor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainApplication {
    public static void main(String[] args) throws ParseException, IOException {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("Enter your choice: \n1.Insert\n2.Fetch\n3.Exit");
            int choice = Integer.parseInt(bufferedReader.readLine());
            switch (choice) {
                case 1:
                    DAO.insertRecord();
                    break;

                case 2:
                    FetchDAO.fetchRecords();
                    break;
                case 3:
                    System.out.println("THANKYOU!!");
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
