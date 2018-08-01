package com.gitpitch.git.vendors;

import com.fasterxml.jackson.databind.JsonNode;
import com.gitpitch.git.GRS;
import com.gitpitch.git.GRSService;
import com.gitpitch.models.GitRepoModel;
import com.gitpitch.models.GogsRepoModel;
import com.gitpitch.utils.PitchParams;

public class RawHttp extends GRSService {
  public static final String TYPE = "rawhttp";

  public GitRepoModel model(PitchParams pp, JsonNode json) {
    return GogsRepoModel.build(pp, json);
  }

  @Override
  public String raw(PitchParams pp) {

    GRS grs = grsManager.get(TYPE);

    return new StringBuilder()
            .append(grs.getRawBase())
            .append(pp.user)
            .append(SLASH)
            .append(pp.repo)
            .append(SLASH)
            .toString();
  }

  @Override
  public String repo(PitchParams pp) {
    return raw(pp);
  }

  @Override
  public String gist(PitchParams pp, String gid, String fid) {
    return NOT_FOUND;
  }
}
