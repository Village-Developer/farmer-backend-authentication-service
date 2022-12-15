package village.farmer.controllers;

import org.springframework.web.bind.annotation.*;
import village.farmer.statics.StaticsParameter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/test")
@CrossOrigin(origins = "*")
public class TestController  {

    public static String ignore[] = {"TestController"};

    public interface ctrlPath extends RequestMapping {}
    public interface ctrlGet extends GetMapping {}
    public interface ctrlPost extends PostMapping {}
    public interface ctrlPut extends PutMapping {}
    public interface ctrlPatch extends PatchMapping {}
    public interface methodReqBody extends RequestBody {}
    public interface methodResBody extends ResponseBody {}
    public interface methodPathVar extends PathVariable {}

    @GetMapping("/1")
    @ResponseBody
    public void t1() {
        try {
            List<String> lsCtrl = Files.walk(Paths.get(StaticsParameter.FARMER_PATH + StaticsParameter.CALL_PACKAGE_CONTROLLER))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .filter(n -> n.endsWith(".java"))
                    .collect(Collectors.toList());
            Iterator<String> iterator = lsCtrl.iterator();
            while (iterator.hasNext()) {
                String str = iterator.next();
                for (String arr:ignore) {
                    if (str.contains(arr)) {
                        iterator.remove();
                    }
                }
            }
            for (String val:lsCtrl) {
                val = val.replace(".java","");
                Class ctrl = Class.forName(StaticsParameter.FARMER_PACKAGE+StaticsParameter.CALL_PACKAGE_CONTROLLER+"."+val);

                for (Annotation annotation: ctrl.getAnnotations()) {

                }
                //method layer
                for (Method method:ctrl.getDeclaredMethods()) {
                    for (Annotation annotation:method.getDeclaredAnnotations()) {
//                        System.out.println("+"+annotation);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}