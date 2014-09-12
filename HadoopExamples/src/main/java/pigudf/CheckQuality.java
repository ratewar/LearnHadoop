package pigudf;

import org.apache.pig.FilterFunc;
import org.apache.pig.FuncSpec;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.data.DataType;
import org.apache.pig.data.Tuple;
import org.apache.pig.impl.logicalLayer.FrontendException;
import org.apache.pig.impl.logicalLayer.schema.Schema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by rajat on 12/9/14.
 * This class extends the FilterFunc class for org.apache.pig.FilterFunc
 * This is a UDF for enhancing the Pig Filtering
 */
public class CheckQuality extends FilterFunc{
    @Override
    public Boolean exec(Tuple input) throws IOException {
        if(input==null || input.size()==0) {
            return null;
        }
        try
        {
            Object object=input.get(0);
            if(object==null)
            {
                return null;
            }
            int i=(Integer) object;
            return i==0 || i==1 || i==4 || i == 5|| i==9;
        }
        catch (ExecException e)
        {
            throw new IOException(e);
        }
    }

    @Override
    public List<FuncSpec> getArgToFuncMapping() throws FrontendException {
        List<FuncSpec> funcSpecs = new ArrayList<FuncSpec>();
        funcSpecs.add(new FuncSpec(this.getClass().getName(),
                new Schema(new Schema.FieldSchema(null, DataType.INTEGER))));

        return funcSpecs;
    }

}
