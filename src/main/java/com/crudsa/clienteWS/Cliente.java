
package com.crudsa.clienteWS;

import com.crudsa.vo.LibroVO;
import java.util.List;

public interface Cliente {
    public List<LibroVO> listaLibros() throws Exception;
}
