import { TestBed } from '@angular/core/testing';

import { NavFilterService } from './nav-filter.service';

describe('NavFilterService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: NavFilterService = TestBed.get(NavFilterService);
    expect(service).toBeTruthy();
  });
});
