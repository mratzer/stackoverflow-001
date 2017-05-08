package org.marat.stackoverflow001;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Stackoverflow001 {

    private static final Logger logger = LoggerFactory.getLogger(Stackoverflow001.class);

    static {
        System.setProperty("org.jboss.logging.provider", "slf4j");
    }

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sw2000");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            work(entityManager);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    private static void work(EntityManager entityManager) {
        logger.info("Fetching data ...");

        List<TableOneEntity> resultList = entityManager
                .createNamedQuery(TableOneEntity.FIND_BY_SOME_DATA, TableOneEntity.class)
                .setParameter("someData", "someData")
                .getResultList();

        logger.info("Data fetched.");

        resultList.forEach(one -> logger.info("{} / {} ({}) has two: {}",
                one.getSomeString(),
                one.getSomeInteger(),
                one.getSomeIndex(),
                one.getTableTwoEntity() != null));
    }

}
