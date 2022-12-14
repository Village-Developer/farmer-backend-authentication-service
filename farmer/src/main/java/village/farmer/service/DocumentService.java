package village.farmer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import village.farmer.model.DocCtrlModel;
import village.farmer.model.response.DocCtrlResponse;
import village.farmer.statics.StaticsParameter;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService {

    public static String ignoreController[] = {"TestController"};
    public static String ignoreModel[] = {};

    public void listCtrl () throws IOException, ClassNotFoundException {
        DocCtrlResponse response = new DocCtrlResponse();
        ArrayList<DocCtrlModel> arrLs = new ArrayList<>();
        HashMap<String,String> body = new HashMap<>();
        List<String> lsCtrl = Files.walk(Paths.get(StaticsParameter.FARMER_PATH + StaticsParameter.CALL_PACKAGE_CONTROLLER))
                .map(Path::getFileName)
                .map(Path::toString)
                .filter(n -> n.endsWith(".java"))
                .collect(Collectors.toList());
        Iterator<String> iterator = lsCtrl.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            for (String arr:ignoreController) {
                if (str.contains(arr)) {
                    iterator.remove();
                }
            }
        }
        // class layer
        for (String val:lsCtrl) {
            DocCtrlModel model = new DocCtrlModel();
            val = val.replace(".java","");
            Class ctrl = Class.forName(StaticsParameter.FARMER_PACKAGE+StaticsParameter.CALL_PACKAGE_CONTROLLER+"."+val);
            model.setName(ctrl.getSimpleName());

            for (Annotation annotation: ctrl.getDeclaredAnnotations()) {
                System.out.println("-->"+annotation);
            }
            //method layer
            for (Method method:ctrl.getDeclaredMethods()) {
                for (Annotation annotation:method.getDeclaredAnnotations()) {
                    System.out.println("+"+annotation);
                }
            }
        }
//        for (String val:lsCtrl) {
//            DocCtrlModel model = new DocCtrlModel();
//            val = val.replace(".java","");
//            Class ctrl = Class.forName(StaticsParameter.FARMER_PACKAGE+StaticsParameter.CALL_PACKAGE_CONTROLLER+"."+val);
//            model.setName(ctrl.getSimpleName());
//            for (Method method:ctrl.getMethods()) {
//                if (method.toString().contains(val)){
//                    for (Parameter parameter: method.getParameters()) {
//                        HashMap<String,String> attribute = new HashMap<>();
//                        Class c = Class.forName(parameter.getType().getTypeName());
//                        if (c.getName().contains(StaticsParameter.FARMER_PACKAGE)) {
//                            HashMap<String,String> a = new HashMap<>();
//                            for (Field field : c.getDeclaredFields()) {
//                                field.setAccessible(true);
//                                a.put(field.getName(), field.getType().getSimpleName());
//                            }
//                            attribute.put(parameter.getName(),new ObjectMapper().writeValueAsString(a));
//                        }
//                        else {
//                            attribute.put(c.getSimpleName(),c.getTypeName());
//                        }
//                    }
//                }
//            }
//        }
    }
}
