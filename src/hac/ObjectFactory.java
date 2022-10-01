//----------------------------------------------------------------------------------------------------------------------
package hac;
//----------------------------------------------------------------------------------------------------------------------
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
//----------------------------------------------------------------------------------------------------------------------
/**
 * This class is a factory , responsible to create objects.
 */
public class ObjectFactory {
      final static Map<ObjectType, Supplier<Object>> map = new HashMap<>();

    /**
     * This function is responsible for creating an object.
     * @param type
     * @param createFunction
     */
      public void register(ObjectType type, Supplier<Object> createFunction){
          map.put(type, createFunction);
      }

    /**
     * This function responsible for returning object according the type.
     * @param type
     * @return
     */
      public Object getObject(ObjectType type){
          Supplier<Object> createFunction = map.get(type);
          if(createFunction != null)
             return createFunction.get();
          throw new IllegalArgumentException("No such Object in our factory: " + type.name());
      }
}
//----------------------------------------------------------------------------------------------------------------------