package com.aaron.learn.spring_core.test.componentscan;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 17:50 2019/10/8
 * @Modiflid By:
 */
public class DemoTypeFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取正在扫描类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源（类路径）
        Resource resource =  metadataReader.getResource();

        String className = classMetadata.getClassName();

        if(className.contains("Service")){
            return true;
        }

        return false;
    }
}
