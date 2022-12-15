package village.farmer.model.response;

import village.farmer.model.DocCtrlModel;
import village.farmer.model.GenericsResponseModel;

import java.util.List;

public class DocCtrlResponse extends GenericsResponseModel {
    private List<DocCtrlModel> controller;

    public List<DocCtrlModel> getController() {
        return controller;
    }

    public void setController(List<DocCtrlModel> controller) {
        this.controller = controller;
    }
}
