public class MultiDimArrayAsArrayView {
    private int [] MultiDimArray;
    private int length;

    public MultiDimArrayAsArrayView(int[][]mat){
        length =0;
        matLength(mat);
        MultiDimArray=new int[length];
        convert2dArrayToArray(mat);

    }
    public MultiDimArrayAsArrayView(int[][][]mat){
        length =0;
        mat3dLength(mat);
        MultiDimArray=new int[length];
        convert3dArrayToArray(mat);

    }
    public void mat3dLength(int[][][]mat3d)
    {
        for(int i=0;i<mat3d.length;i++)
        {
            matLength(mat3d[i]);
        }
    }

    public void matLength(int[][]mat)
    {
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                length++;
            }
        }
    }

    public void convert2dArrayToArray(int[][]mat)
    {
        int indexArray=0;
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                MultiDimArray[indexArray++]=mat[i][j];
            }
        }
    }

    public void convert3dArrayToArray(int[][][]mat3d)
    {
        for(int i=0;i<mat3d.length;i++)
        {
            convert2dArrayToArray(mat3d[i]);

        }
    }

    public int getIndexArray(int index)
    {
        return MultiDimArray[index];
    }

    public int getLength(int index)
    {
        return length;
    }

    public int getFirstIndex()
    {
        return MultiDimArray[0];
    }

    public int getLastIndex()
    {
        return MultiDimArray[MultiDimArray.length-1];
    }


}
