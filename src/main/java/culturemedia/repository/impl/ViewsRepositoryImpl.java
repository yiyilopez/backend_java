package culturemedia.repository.impl;

import culturemedia.model.View;
import culturemedia.repository.ViewsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ViewsRepositoryImpl implements ViewsRepository{
    List <View> views = new ArrayList<>();



@Override
public View add(View view) {
    views.add(view);
    return view;

}

}
