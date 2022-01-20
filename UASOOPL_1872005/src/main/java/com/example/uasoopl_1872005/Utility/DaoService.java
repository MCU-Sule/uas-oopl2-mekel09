package com.example.uasoopl_1872005.Utility;

import java.util.List;
/**Michael Sebastian Gunadi-1872005*/

public interface DaoService<T> {

    int addData(T Object);

    int deleteData(T Object);

    int updateData(T Object);

    List<T> fetchall();
}
