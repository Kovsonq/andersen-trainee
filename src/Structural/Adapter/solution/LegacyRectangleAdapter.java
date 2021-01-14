package Structural.Adapter.solution;

public class LegacyRectangleAdapter extends Rectangular {

    private LegacyRectangular legacyRectangular;

    public LegacyRectangleAdapter(LegacyRectangular legacyRectangular) {
        this.legacyRectangular = legacyRectangular;
    }

    @Override
    public Integer determineSize() {
        return legacyRectangular.calculateSize();
    }
}