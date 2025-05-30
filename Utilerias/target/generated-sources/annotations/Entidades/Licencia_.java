package Entidades;

import Entidades.Persona;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-30T15:22:33", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Licencia.class)
public class Licencia_ { 

    public static volatile SingularAttribute<Licencia, Persona> dueno;
    public static volatile SingularAttribute<Licencia, Long> idLicencia;
    public static volatile SingularAttribute<Licencia, String> tipoLicencia;
    public static volatile SingularAttribute<Licencia, Double> costo;
    public static volatile SingularAttribute<Licencia, Date> fechaInicio;
    public static volatile SingularAttribute<Licencia, Date> fechaFin;

}