package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query; // Ensure you import Query
import pojo.Category;
import pojo.Choice; // Ensure you import Choice
import pojo.Question; // Ensure you import Question
import util.HibernateUtil;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        // First session: Fetch and print categories
        try (Session session = sessionFactory.openSession()) {
            Query<Category> q = session.createQuery("FROM Category", Category.class);
            List<Category> categories = q.list();
            categories.forEach(c -> {
                System.out.println(c.getName());
            });
            session.close();
        }

        // Second session: Save a new category
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Category cate = new Category("Cate04", "Pronoun");
            session.save(cate);

            transaction.commit();
        }

        // Third session: Update a category
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            // Fetch category by primary key
            Category cate = session.get(Category.class, "Cate02");

            // Update category
            cate.setName("Verb Tenses");
            session.update(cate);

            transaction.commit();
        }

        // Fourth session: Create a question and its choices
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Category c1 = session.get(Category.class, "Cate01");
            Category c2 = session.get(Category.class, "Cate02");

            Question q = new Question("Q0001", "This is a ... book");
            q.getCategories().addAll(Arrays.asList(c1, c2));
            session.save(q);

            Choice a = new Choice("C0001", "well", false, q);
            Choice b = new Choice("C0002", "good", false, q);
            Choice c = new Choice("C0003", "lovely", false, q);
            Choice d = new Choice("C0004", "beautiful", false, q);

            session.save(a);
            session.save(b);
            session.save(c);
            session.save(d);

            transaction.commit();
        }


    }
}
