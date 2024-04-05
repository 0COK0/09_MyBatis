package com.ohgiraffers.section.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {
        private static String DRIVER = "com.mysql.cj.jdbc.Driver";

        private static String URL = "jdbc:mysql://localhost/menudb";
        private static String USER = "ohgiraffers";
        private static String PASSWORD = "ohgiraffers";


    public static void main(String[] args) {

        /* DB 접속에 관한 환경 설정
        * JdbcTransactionFactory : 수동 커밋
        * ManagedTransactionFactory : 자동 커밋
        * PooledDataSource : ConnectionPool 사용
        * UnpooledDataSource : ConnectionPool 미사용
        * ConnectionPool : 커넥션을 미리 만들어 놓고 보관하는 Pool
        * */

        Environment environment =
                    new Environment("dev"
                    , new JdbcTransactionFactory()
                    , new PooledDataSource(DRIVER, URL, USER, PASSWORD));

//        Configuration configuration = new Configuration(environment);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(Mapper.class);

        /* SqlSeessionFactory : SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
        *  SqlSeessionFactoryBuilder :  SqlSeesionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 빌드 역할
        *  build() : 설정에 대한 정보를 담고 있는 configuration 타입의 객체혹은 외부 설정 파일과 연결된 Stram
        *            매개 변수로 전달 SqlSeessionFactory 인터페이스 타입의 객체를 반환하는 메소드*/

//        SqlSeessionFactory sqlSeessionFactory = new SqlSessionFactoryBuilder().Builder.(configuration);
        SqlSessionFactory sqlSeessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        /* openSession() : SqlSession 인터페이스 타입의 객체를 반환하는 메소드를 블른 타입을 인자로 전달
        * -false : Connection 인터페이스 타입 객체로 DML 수행 후 auto commit에 옵션을 false로 지정 (권장)
        * -true :  Connection 인터페이스 타입 객체로 DML 수행 후 auto commit에 옵션을 true로 지정
        *
        *

        * */
        SqlSession session = sqlSeessionFactory.openSession(false);

        /* getMapper() : Configuration에 등록된 메퍼를 동일 타입에 대해 반환하는 메소드*/
        Mapper mapper = session.getMapper(Mapper.class);

    /* Mapper 인터페이스에 작성된 메소드를 호출하여 쿼리 실행*/
        java.util.Date date = mapper.selectSysdate();

 /* close() : SqlSession 객체 반납*/
        System.out.println("date = " + date);
    }
}
