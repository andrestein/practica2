package octographs;

import java.util.Objects;

public class Relacion
{

    //La relacion elemento1 apunta a elemento2

    private Elemento elemento1, elemento2;

    public void setElemento1(Elemento elemento1)
    {
        this.elemento1 = elemento1;
    }

    public Elemento getElemento1()
    {
        return elemento1;
    }

    public void setElemento2(Elemento elemento2)
    {
        this.elemento2 = elemento2;
    }

    public Elemento getElemento2()
    {
        return elemento2;
    }

    @Override
    public String toString()
    {
        return elemento1 + " - " + elemento2;
    }

    @Override
    public boolean equals(Object relacion)
    {
        if ((Relacion)relacion == this)
            return true;

        if (elemento1.equals(((Relacion) relacion).getElemento1())
          && elemento2.equals(((Relacion) relacion).getElemento2()))
            return true;

        return false;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.elemento1);
        hash = 23 * hash + Objects.hashCode(this.elemento2);
        return hash;
    }
}
