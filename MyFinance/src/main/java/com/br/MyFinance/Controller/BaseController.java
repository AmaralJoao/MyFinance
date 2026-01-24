package com.br.MyFinance.Controller;

import com.br.MyFinance.Mapper.BaseMapper;

public class BaseController<REQ, RESP, MODEL> {

    protected final BaseMapper<REQ, RESP, MODEL> mapper;

    public BaseController(BaseMapper<REQ, RESP, MODEL> mapper) {
        this.mapper = mapper;
    }

    protected MODEL requestToModel(REQ request){
        return mapper.requestToModel(request);
    }

    protected RESP ModeloResponse(MODEL model){
        return mapper.toDto(model);
    }
}
