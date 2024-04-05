package com.ohgiraffer.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {
    /* SqlSessionFactory는 어플리케이션을 실행하는 동안 존재해야하며,
    * 어플리케이션이 실행되는 동안 여러 차례 를 다시 빌드하지 않는 것이 가장 좋은 형태이다.
    * 어*/

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {
        /* SqlSessionFactoryBuilder를 SqlSession을 생성한 후에도 유지할 필요는 없다.
        * 따라서 메소드 스코프로 만든다.
        * 여러 개의 SqlSessionFactoty를 빌드하기 위해 재사용할 수도 있지만 유지하지 않는 것이 가장 좋다. */

        if (sqlSessionFactory == null) {
            String resource = "mybatis-config.xml";

            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /* 은 스레드에 안전하지 않고, 공유되지 않아야 하므로 요청 시마다 생성해야 한다.
        * 요청 시 생성하고 요청이 완료되면 close하는 http 요청과 유사한 스코프에 두는 것이 가장 올바른 방법이다.
        *
        * */

        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        System.out.println("sqlSessionFactory의 hasCode() : " + sqlSessionFactory.hashCode());
        System.out.println("sqlSession의 hasCode() : " + sqlSession.hashCode());



        return sqlSession;

    }
}
