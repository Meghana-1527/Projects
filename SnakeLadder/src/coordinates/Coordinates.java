package coordinates;

public class Coordinates {
    int row;
    int column;

    public Coordinates(int row,int column){
        this.row=row;
        this.column=column;

    }

    public String printCoordinates(){
        StringBuilder sb=new StringBuilder();
        sb.append("[").append(this.row).append(",").append(this.column).append("]");
        return sb.toString();
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.column;
    }
}
