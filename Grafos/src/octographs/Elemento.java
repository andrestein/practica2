package octographs;

public class Elemento
{

    private int x, y;
    private String nombre;

    public void setX(int x)
    {
        this.x = x;
    }

    public int getX()
    {
        return x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getY()
    {
        return y;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return nombre;
    }

    @Override
    public String toString()
    {
        return nombre;
    }

    @Override
    public boolean equals(Object elemento)
    {
        if (this == elemento)
            return true;
        return nombre.equalsIgnoreCase(((Elemento) elemento).getNombre());
    }
}
