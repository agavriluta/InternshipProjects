package stage4.contactsFactory;

import stage4.Validator;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.reflect.Modifier.isProtected;
    public abstract class Contact implements Serializable {
        private static final long serialVersionUID = -6974594304581876842L;
        protected String name;
        protected String number;
        LocalDateTime creationDateTime;
        LocalDateTime lastEditDateTime;

        final void setName(String name) {
            this.name = name;
        }

        final void setNumber(String number) {
            this.number = number;
        }

        final void setCreationDateTime(LocalDateTime creationDateTime) {
            this.creationDateTime = creationDateTime;
        }

        public final void setLastEditDateTime(LocalDateTime lastEditDateTime) {
            this.lastEditDateTime = lastEditDateTime;
        }

        public abstract void setFieldByName(String fieldName, String newValue);

        public final List<Field> getAllFieldNames() {
            final List<Field> allFields = new ArrayList<>(30);
            Collections.addAll(allFields, getClass().getDeclaredFields());
            Class<?> currentClass = getClass().getSuperclass();
            while (null != currentClass) {
                final Field[] declaredFields = Arrays
                        .stream(currentClass.getDeclaredFields())
                        .filter(filed -> isProtected(filed.getModifiers()))
                        .toArray(Field[]::new);
                Collections.addAll(allFields, declaredFields);
                currentClass = currentClass.getSuperclass();
            }
            return allFields;
        }

        public abstract String[] getEditableFields();

        String filterPhoneNumber(String number) {
            String result;
            if (Validator.checkNumber(number)) {
                result = number;
            } else {
                System.out.println("Wrong number format!");
                result = "";
            }
            return result;
        }

        public abstract void showContactsListItem(int index);

        public abstract void showEditableFields();
    }
