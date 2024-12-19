import com.vaadin.flow.component.grid.Grid;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GridUtils {

    public static <T> void setAllColumnsResizable(Grid<T> grid, boolean isResizable, Grid.Column<T>... excludedColumns) {
        getFilteredColumns(grid, excludedColumns).forEach(column -> column.setResizable(isResizable));
    }

    public static <T> void setAllColumnsSortable(Grid<T> grid, boolean isSortable, Grid.Column<T>... excludedColumns) {
        getFilteredColumns(grid, excludedColumns).forEach(column -> column.setSortable(isSortable));
    }

    public static <T> void setAllColumnsAutoWidth(Grid<T> grid, boolean isAutoWidth, Grid.Column<T>... excludedColumns) {
        getFilteredColumns(grid, excludedColumns).forEach(column -> column.setAutoWidth(isAutoWidth));
    }

    private static <T> List<Grid.Column<T>> getFilteredColumns(Grid<T> grid, Grid.Column<T>... excludedColumns) {
        Map<Grid.Column<?>, Boolean> excludedMap = Arrays.stream(excludedColumns).collect(Collectors.toMap(column -> column, column -> true));
        grid.getColumns().stream()
                .filter(column -> !excludedMap.containsKey(column))
                .collect(Collectors.toList());
    }

}
