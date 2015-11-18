package org.czocher.swingmvp.views;

public interface View<V, P> {

    P getPresenter();

    void setPresenter(P presenter);

    V getConcrete();

    void show();

    void hide();
}
