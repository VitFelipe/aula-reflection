package org.example.refl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TransformModel {

    public <I, O> O transform(Object input) throws ClassNotFoundException {
        try {
            Class<?> inputRef = input.getClass();
            Class<?> targetRef = Class.forName(inputRef.getName() + "DTO");
            targetRef.getConstructor().newInstance();

            O classTarget = (O) targetRef.getConstructor().newInstance();
            List<Field> fieldsTarget = Arrays.asList(classTarget.getClass().getDeclaredFields());
            for (Field field : Arrays.asList(inputRef.getDeclaredFields())) {
                Field fieldDTO = getFieldDTO(fieldsTarget, field);
                if (fieldDTO != null) {
                    field.setAccessible(true);
                    fieldDTO.setAccessible(true);
                    Object value = field.get(input); //findMethod(Arrays.asList(inputRef.getMethods()),field.getName(),TipoMethod.GET).invoke(input);
                    fieldDTO.set(classTarget, value);
                    // findMethod(Arrays.asList(targetRef.getMethods()),fieldDTO.getName(),TipoMethod.SET).invoke(classTarget,value);

                }
            }
            return classTarget;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }


    private Field getFieldDTO(List<Field> fieldsDTO, Field fieldParam) {
        return fieldsDTO.stream().
                filter(field -> field.getName().
                        equalsIgnoreCase(fieldParam.getName()) && field.getType().equals(fieldParam.getType())).findAny().orElse(null);
    }

    /*
      Para conseguir manipular um atributo  privado de uma classe  basta usar  o methodo setAcessible e passar como parametro o valor true
     */

//    private Method findMethod(List<Method> methodList, String nomeField, TipoMethod tipoMethod) {
//        return methodList.stream().filter(method -> method.getName().
//                        substring(3).equalsIgnoreCase(nomeField) && method.getName().trim().startsWith(tipoMethod.descricao)).
//                findAny().orElseThrow(() -> new RuntimeException
//                        ("Não foi encontrado um metodo get para o atributo %s".formatted(nomeField)));
//    }


    enum TipoMethod {
        GET("get"),
        SET("set");
        private String descricao;

        TipoMethod(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

}
