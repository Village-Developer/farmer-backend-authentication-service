package village.farmer.model.response;

import lombok.Getter;
import lombok.Setter;
import village.farmer.model.DocCtrlModel;
import village.farmer.model.GenericsResponseModel;

import java.util.List;

@Getter
@Setter
public class DocCtrlResponse extends GenericsResponseModel {
    private List<DocCtrlModel> controller;

}
