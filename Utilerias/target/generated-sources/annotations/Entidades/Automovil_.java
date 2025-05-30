package Entidades;

import Entidades.Persona;
import Entidades.Placa;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-30T12:23:49", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Automovil.class)
public class Automovil_ { 

    public static volatile SingularAttribute<Automovil, String> numeroSerie;
    public static volatile SingularAttribute<Automovil, String> marca;
    public static volatile SingularAttribute<Automovil, Persona> dueno;
    public static volatile SingularAttribute<Automovil, String> color;
    public static volatile SingularAttribute<Automovil, String> modelo;
    public static volatile SingularAttribute<Automovil, String> linea;
    public static volatile ListAttribute<Automovil, Placa> placas;

}