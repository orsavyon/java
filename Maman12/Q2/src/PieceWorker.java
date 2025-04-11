/**
 * Represents an employee who is paid per item produced.
 */
class PieceWorker extends Employee {
    private double wagePerPiece;
    private int piecesProduced;

    /**
     * Constructs a PieceWorker.
     * @param firstName the first name
     * @param lastName the last name
     * @param ssn the social security number
     * @param birthDate the birth date
     * @param wagePerPiece the pay per piece
     * @param piecesProduced the number of pieces produced
     */
    public PieceWorker(String firstName, String lastName, String ssn, Date birthDate,
                       double wagePerPiece, int piecesProduced) {
        super(firstName, lastName, ssn, birthDate);
        this.wagePerPiece = wagePerPiece;
        this.piecesProduced = piecesProduced;
    }

    /** @return the total earnings as wage per piece times pieces produced */
    public double earnings() {
        return wagePerPiece * piecesProduced;
    }

    /** @return string representation */
    public String toString() {
        return "Piece worker: " + super.toString();
    }
}
