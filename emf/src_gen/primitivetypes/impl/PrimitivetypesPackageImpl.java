/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package primitivetypes.impl;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import primitivetypes.PrimitivetypesFactory;
import primitivetypes.PrimitivetypesPackage;
import asmeta.definitions.DefinitionsPackage;
import asmeta.definitions.domains.DomainsPackage;
import asmeta.definitions.domains.impl.DomainsPackageImpl;
import asmeta.definitions.impl.DefinitionsPackageImpl;
import asmeta.structure.StructurePackage;
import asmeta.structure.impl.StructurePackageImpl;
import asmeta.terms.basicterms.BasictermsPackage;
import asmeta.terms.basicterms.impl.BasictermsPackageImpl;
import asmeta.terms.furtherterms.FurthertermsPackage;
import asmeta.terms.furtherterms.impl.FurthertermsPackageImpl;
import asmeta.transitionrules.basictransitionrules.BasictransitionrulesPackage;
import asmeta.transitionrules.basictransitionrules.impl.BasictransitionrulesPackageImpl;
import asmeta.transitionrules.derivedtransitionrules.DerivedtransitionrulesPackage;
import asmeta.transitionrules.derivedtransitionrules.impl.DerivedtransitionrulesPackageImpl;
import asmeta.transitionrules.turbotransitionrules.TurbotransitionrulesPackage;
import asmeta.transitionrules.turbotransitionrules.impl.TurbotransitionrulesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PrimitivetypesPackageImpl extends EPackageImpl implements PrimitivetypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType integerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType longEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType floatEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType doubleEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType booleanEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stringEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see primitivetypes.PrimitivetypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PrimitivetypesPackageImpl() {
		super(eNS_URI, PrimitivetypesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link PrimitivetypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PrimitivetypesPackage init() {
		if (isInited) return (PrimitivetypesPackage)EPackage.Registry.INSTANCE.getEPackage(PrimitivetypesPackage.eNS_URI);

		// Obtain or create and register package
		PrimitivetypesPackageImpl thePrimitivetypesPackage = (PrimitivetypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PrimitivetypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PrimitivetypesPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		FurthertermsPackageImpl theFurthertermsPackage = (FurthertermsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FurthertermsPackage.eNS_URI) instanceof FurthertermsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FurthertermsPackage.eNS_URI) : FurthertermsPackage.eINSTANCE);
		BasictermsPackageImpl theBasictermsPackage = (BasictermsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BasictermsPackage.eNS_URI) instanceof BasictermsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BasictermsPackage.eNS_URI) : BasictermsPackage.eINSTANCE);
		StructurePackageImpl theStructurePackage = (StructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI) instanceof StructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI) : StructurePackage.eINSTANCE);
		TurbotransitionrulesPackageImpl theTurbotransitionrulesPackage = (TurbotransitionrulesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TurbotransitionrulesPackage.eNS_URI) instanceof TurbotransitionrulesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TurbotransitionrulesPackage.eNS_URI) : TurbotransitionrulesPackage.eINSTANCE);
		DerivedtransitionrulesPackageImpl theDerivedtransitionrulesPackage = (DerivedtransitionrulesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DerivedtransitionrulesPackage.eNS_URI) instanceof DerivedtransitionrulesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DerivedtransitionrulesPackage.eNS_URI) : DerivedtransitionrulesPackage.eINSTANCE);
		BasictransitionrulesPackageImpl theBasictransitionrulesPackage = (BasictransitionrulesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BasictransitionrulesPackage.eNS_URI) instanceof BasictransitionrulesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BasictransitionrulesPackage.eNS_URI) : BasictransitionrulesPackage.eINSTANCE);
		DefinitionsPackageImpl theDefinitionsPackage = (DefinitionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DefinitionsPackage.eNS_URI) instanceof DefinitionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DefinitionsPackage.eNS_URI) : DefinitionsPackage.eINSTANCE);
		DomainsPackageImpl theDomainsPackage = (DomainsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DomainsPackage.eNS_URI) instanceof DomainsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DomainsPackage.eNS_URI) : DomainsPackage.eINSTANCE);

		// Create package meta-data objects
		thePrimitivetypesPackage.createPackageContents();
		theFurthertermsPackage.createPackageContents();
		theBasictermsPackage.createPackageContents();
		theStructurePackage.createPackageContents();
		theTurbotransitionrulesPackage.createPackageContents();
		theDerivedtransitionrulesPackage.createPackageContents();
		theBasictransitionrulesPackage.createPackageContents();
		theDefinitionsPackage.createPackageContents();
		theDomainsPackage.createPackageContents();

		// Initialize created meta-data
		thePrimitivetypesPackage.initializePackageContents();
		theFurthertermsPackage.initializePackageContents();
		theBasictermsPackage.initializePackageContents();
		theStructurePackage.initializePackageContents();
		theTurbotransitionrulesPackage.initializePackageContents();
		theDerivedtransitionrulesPackage.initializePackageContents();
		theBasictransitionrulesPackage.initializePackageContents();
		theDefinitionsPackage.initializePackageContents();
		theDomainsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePrimitivetypesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PrimitivetypesPackage.eNS_URI, thePrimitivetypesPackage);
		return thePrimitivetypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getInteger() {
		return integerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLong() {
		return longEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFloat() {
		return floatEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDouble() {
		return doubleEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getBoolean() {
		return booleanEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getString() {
		return stringEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitivetypesFactory getPrimitivetypesFactory() {
		return (PrimitivetypesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create data types
		integerEDataType = createEDataType(INTEGER);
		longEDataType = createEDataType(LONG);
		floatEDataType = createEDataType(FLOAT);
		doubleEDataType = createEDataType(DOUBLE);
		booleanEDataType = createEDataType(BOOLEAN);
		stringEDataType = createEDataType(STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Initialize data types
		initEDataType(integerEDataType, Integer.class, "Integer", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(longEDataType, Long.class, "Long", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(floatEDataType, Float.class, "Float", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(doubleEDataType, Double.class, "Double", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(booleanEDataType, Boolean.class, "Boolean", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(stringEDataType, String.class, "String", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //PrimitivetypesPackageImpl
