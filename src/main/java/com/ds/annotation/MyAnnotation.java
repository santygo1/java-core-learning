package com.ds.annotation;

/**
 * @author Danil on 08.12.2022
 * @project JavaCoreLearning
 */

/*
    Аннотации без элементов - маркерные.
    Когда одну анотацию указывают для другой аннотации - мета аннотация.
    Одна из мета-анотаций - Retention.

    RetentionPolicy:
        1)SOURCE - используется на этапе компиляции, и обрабатывается компилятором.
        2)CLASS - будет записана в класс, но доступна в рантайме
        3)RUNTIME - записывается в class и доступна в рантайме с помощью рефлекшион.
                                                (Более часто используется при разработке)
 */
public @interface MyAnnotation {
    String title();
    int version() default 1;
    String text();
}
