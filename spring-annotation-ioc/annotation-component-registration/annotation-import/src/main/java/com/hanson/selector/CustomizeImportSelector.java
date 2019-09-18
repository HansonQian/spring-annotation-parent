package com.hanson.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义导入选择器，该方式是将注册权限交给了容器可以理解为控制反转
 */
public class CustomizeImportSelector implements ImportSelector {


    /**
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
     * @return 需要导入到容器中的组件全类名数组, 该方法不能返回null
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.hanson.bean.Red"};
    }
}
