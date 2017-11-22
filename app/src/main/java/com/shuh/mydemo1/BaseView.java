package com.shuh.mydemo1;

import android.support.annotation.NonNull;

/**
 * Created by pc-135 on 2017/11/20.
 */

public interface BaseView<T> {

    void setPresenter(@NonNull T presenter);
}
